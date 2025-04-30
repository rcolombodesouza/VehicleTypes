#!/bin/bash
set -e

ES_HOST="elasticsearch"
ES_PORT="9200"

wait_for_es() {
  until curl -s "http://${ES_HOST}:${ES_PORT}" >/dev/null; do
    echo "Aguardando Elasticsearch em ${ES_HOST}:${ES_PORT}..."
    sleep 2
  done
}

create_template() {
  local name=$1
  local pattern=$2
  echo "Criando template para ${name}..."
  curl -s -X PUT "http://${ES_HOST}:${ES_PORT}/_index_template/${name}-template" \
    -H "Content-Type: application/json" \
    -d "{
      \"index_patterns\": [\"${pattern}*\"],
      \"data_stream\": {},
      \"template\": {
        \"mappings\": {
          \"properties\": {
            \"@timestamp\": { \"type\": \"date\" }
          }
        }
      }
    }"
  echo
}

create_metrics_template_with_dynamic_counter() {
  echo "Criando template dinâmico para vehicletype-metrics com counters, gauges e histogram..."
  curl -s -X PUT "http://${ES_HOST}:${ES_PORT}/_index_template/vehicletype-metrics-template" \
    -H "Content-Type: application/json" \
    -d '{
      "index_patterns": ["vehicletype-metrics*"],
      "data_stream": {},
      "template": {
        "mappings": {
          "dynamic_templates": [
            { "counter_long":   { "match_mapping_type": "long",   "mapping": { "type": "long"   } } },
            { "gauge_long":     { "match_mapping_type": "long",   "mapping": { "type": "long"   } } },
            { "counter_double": { "match_mapping_type": "double", "mapping": { "type": "double" } } },
            { "gauge_double":   { "match_mapping_type": "double", "mapping": { "type": "double" } } },
            { "histogram":      { "match_mapping_type": "object", "match": "metrics.*.gc.duration", "mapping": { "type": "object" } } }
          ],
          "properties": {
            "@timestamp": { "type": "date" }
          }
        }
      }
    }'
  echo
}

wait_for_es

create_metrics_template_with_dynamic_counter
create_template "vehicletype-logs" "vehicletype-logs"
create_template "vehicletype-traces" "vehicletype-traces"

echo "Templates criados com sucesso."