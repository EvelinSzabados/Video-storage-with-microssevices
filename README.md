This assignment is about writing a software that is a network of loosely coupled web services. The different services communicate over REST Apis and are able to cooperate even if they are not on the same computer or are written in different languages.<br>
## Service architecture

- Eureka Server for service discovery
- Zuul for API Gateway
- Video service
  - store Video entities in its own database (H2 is fine)
  - properties: id, name, url (yes, these videos are coming from YouTube or Vimeo)
  - able to retrieve all videos (without recommendations) on a REST endpoint (GET)
  - able to retrieve videos+recommendations by a video id on a REST endpoint (GET)
  - able to update a video and it's recommendations (POST)
  - generates some video entities at startup time (via a CommandLineRunner or a @PostConstruct method) to have sample data (3-4 videos are enough)
- Video recommendation service
  - store Recommendations in its own database (H2 is fine)
  - properties: id, rating (integer, 1-5), comment, videoId
  - able to retrieve all recommendations for a videoId (GET)
  - able to save a new recommendation for a videoId
  - extra: update existing records
