N2N - Technial Assessment - Java Developer - October 2024

Swagger URL : http://localhost:{{portNo}}/n2n/swagger-ui/index.html#/

1. Endpoint -> @GetMapping -> http://localhost:{{portNo}}/n2n/cardgame/cards/all
     - Request Parameter : none
3. Endpoint -> @PostMapping -> http://localhost:{{portNo}}/n2n/cardgame/cards/{onePlayerNumber}
     - Request Parameter : 1 / 2 / 3 / 4
5. Endpoint -> @PostMapping -> http://localhost:{{portNo}}/n2n/cardgame/cards/allPlayers
     -  Request Parameter
         [
            {
              "allPlayersCards": [
                  {
                    "playerNumber":1
                  },
                  {
                    "playerNumber":2
                  },
                  {
                    "playerNumber":3
                  },
                  {
                    "playerNumber":4
                  }
                ]
            }
        ]

