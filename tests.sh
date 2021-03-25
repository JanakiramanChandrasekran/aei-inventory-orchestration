#!/bin/bash

printf "Listing inventory of store id: 1\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/store/1 | json_pp
sleep 2

printf "Listing inventory of store id: 1000 that doesn't exist\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/store/1000 | json_pp
sleep 2


printf "Inventory: 1 of equipment: AA:BB:CC:DD\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/1 | json_pp
sleep 2

printf "Inventory: 2 of equipment: AA:BB:CC:DD\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/2 | json_pp
sleep 2

printf "Inventory: 5 of equipment: AA2:BB2:CC2:DD2\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/5 | json_pp
sleep 2

printf "Inventory: 1000 doesn't available \n"
curl -X GET http://localhost:80/sell/inventory/api/v1/1000 | json_pp
sleep 2

printf "State of Mac:AA:BB:CC:DD is reported unhealthy, id: 1\n"
curl -w "HttpStatus: %{http_code}\n" -X PUT   http://localhost:8200/event/state/equipment/AA:BB:CC:DD   -H 'cache-control: no-cache'   -H 'content-type: application/json'   -d '{"available":false}'
sleep 2

printf "Inventory: 1 is not available because of equipment: AA:BB:CC:DD\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/1 | json_pp
sleep 2

printf "Inventory: 2 is not available because of equipment: AA:BB:CC:DD\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/2 | json_pp
sleep 2

printf "Inventory: 5 is available as equipment is A2:BB2:CC2:DD2\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/5 | json_pp
sleep 2

printf "Store is open : 1\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/store/1 | json_pp
sleep 2

printf "State of Mac:AA:BB:CC:DD is reported healthy, id: 1\n"
curl -w "HttpStatus: %{http_code}\n" -X PUT   http://localhost:8200/event/state/equipment/AA:BB:CC:DD   -H 'cache-control: no-cache'   -H 'content-type: application/json'   -d '{"available":true}'
sleep 2

printf "Inventory: 1 is available because of equipment: AA:BB:CC:DD\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/1 | json_pp
sleep 2

printf "Inventory: 2 is available because of equipment: AA:BB:CC:DD\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/2 | json_pp
sleep 2

printf "Inventory: 5 is available as no impact\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/5 | json_pp
sleep 2

printf "Store is open : 1\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/store/1 | json_pp
sleep 2

printf "Store hvac is reported unhealthy, id: 1\n"
curl -w "HttpStatus: %{http_code}\n" -X PUT   http://localhost:8200/event/state/store/1   -H 'cache-control: no-cache'   -H 'content-type: application/json'   -d '{"available":false}'
sleep 2

printf "Inventory: 1 is not available as store is not available\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/1 | json_pp
sleep 2

printf "Inventory: 2 is not available as store is not available \n"
curl -X GET http://localhost:80/sell/inventory/api/v1/2 | json_pp
sleep 2

printf "Inventory: 5 is not available as store is not available \n"
curl -X GET http://localhost:80/sell/inventory/api/v1/5 | json_pp
sleep 2

printf "Store is not available : 1\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/store/1 | json_pp
sleep 2

printf "store is reported healthy, id: 1\n"
curl -w "HttpStatus: %{http_code}\n" -X PUT   http://localhost:8200/event/state/store/1   -H 'cache-control: no-cache'   -H 'content-type: application/json'   -d '{"available":true}'
sleep 2

printf "Inventory: 1 is available as store is healthy\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/1 | json_pp
sleep 2

printf "Inventory: 2 is available of equipment: AA:BB:CC:DD\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/2 | json_pp
sleep 2

printf "Inventory: 5 is available of equipment: AA2:BB2:CC2:DD2\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/5 | json_pp
sleep 2

printf "Store is available : 1\n"
curl -X GET http://localhost:80/sell/inventory/api/v1/store/1 | json_pp



