#!/bin/bash
SCHEMA_REGISTRY_URL="http://localhost:9001"

# 모든 스키마 목록 조회
schemas=$(curl -s "${SCHEMA_REGISTRY_URL}/subjects" | jq -r '.[]')

# 모든 스키마 삭제
for schema in $schemas; do
  echo "Deleting schema: $schema"
  curl -X DELETE "${SCHEMA_REGISTRY_URL}/subjects/$schema"
done

echo "All schemas deleted."
