# SWAT

## Case Study

### Pos for a Store

### Frontend

    -login page
    - Billing - Home
    	- Products Selections
    	- quantity selections
    	- Make Order

    - View Orders Histroies
    - View Inventory (Available Stocks)

### Backend

    - MicroServices
    	- Order Management Service (REST API) - Order DB
    	- Inventory Management Service (REST API) - Inventory

    - Kafka Calling: (Restore the quantity for the cancled order)
    	- Producers
    		- OMS Service

    	- Consumer:
    		- IMS service

### Procedural Steps to Start the Application:

    - Backend
    	- cd POS-Backend

    	- Step 1 ( create database in postgres)
    		- run ```psql postgres```
    		- create database inventory
    		- create database orders

    	- Step 2 (start services)
    		- run ```brew start kafka```
    		- run ```brew start zookeeper```
    		- run ```brew start postgres```

    	- Step 3 ( Run MicroServices in intelij)
    		- open each services in intelij
    		- then run the services

    	-Step 4 (Open swagger in browser)
    		- http://localhost:8081/swagger-ui.html (Order Management Service)
    		- http://localhost:8082/swagger-ui.html (Inventory Management Service)

    - Frontend
    	- cd pos-frontend

    	- Step 1 (install nodemodules)
    		- npm i
    	- Step 2 (Edit backend base url)
    		- edit backend base_url in ```/pos-frontend/utils/urls.js```
    	- Step 2 (run the application)
    		- npm run serve

### mock datas

- mock data for inventory in /mockdata/inventory.json
