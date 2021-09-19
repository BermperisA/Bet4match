# Bet4match
tech assessment

Build and run from Maven wrapper
./mvnw clean spring-boot:run

Build and run docker image
docker build --tag=demo-app:latest .
docker run -p 8080:8080 demo-app:latest

Basic service functionality

Get matches
GET http://localhost:8080/matches/         -> All matches
GET http://localhost:8080/matches/1       -> Based on Id

Get all odds
GET http://localhost:8080/matches/odds

Create Match
POST http://localhost:8080/matches/
{
        "description": "OSFP-PAO",
        "matchDate": "2021-09-19",
        "matchTime": "18:45:20",
        "teamA": "OSFP",
        "teamB": "PAO",
        "sport": 1
    }

Create Match Odds
POST http://localhost:8080/matches/1/odds/
{
        "specifier": "1",
        "odd": "2"
    }

Update Match
PUT http://localhost:8080/matches/2/
{
        "description": "OSFP-PAO",
        "matchDate": "2021-09-19",
        "matchTime": "20:45:20",
        "teamA": "OSFP",
        "teamB": "PAO",
        "sport": 1
    }

Update match odds
PUT http://localhost:8080/matches/2/odds/5/
{
        "specifier": "1",
        "odd": "4"
    }

Delete Match
DELETE http://localhost:8080/matches/2/

Delete Odds
DELETE http://localhost:8080/matches/odds/1

