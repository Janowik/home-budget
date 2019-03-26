FROM openjdk:8u191-jdk-alpine3.9
ADD classes/artifacts/home_budget_jar/home-budget.jar .
EXPOSE 8000
CMD java -jar home-budget.jar