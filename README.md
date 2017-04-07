# SearchDemoJava

Application performs search request to a selected search engine(google or yahoo). When application starts, it suggests a user to input query string. After user have entered a query, application asks user to enter search engine name (google or yahoo). Then app makes request to a selected search engine and displays title and url of the first result.


# Realization

I implemented search functionality using factory pattern. This will allow us to easily add other search engines in the future.
  ```Searcher``` - interface that declares 'search' method.
  ```BaseSearcher``` - abstract class which implements Searcher interface and contains common methods to receive and parse any data. In order to receive and parse response I used ```Jsoup``` library (https://jsoup.org/).
  ```GoogleSearcher```, ```YahooSearcher``` - classes that extend ```BaseSearcher``` and contain search engine specific information such as ```baseUrl``` and ```resultPattern```
  ```SearcherFactory``` - class that creates and returns required Searcher implementation
  
 
To communicate with user I created ```ConsoleIO``` class that implements ```IOInterface``` and communicates with user using console. ```IOInterface``` was created to let us easyly add another input/output mechanizm if it is required.



# Tools
- IntelliJ IDEA
- Maven build manager
  
  
