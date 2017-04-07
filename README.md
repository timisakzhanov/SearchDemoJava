# SearchDemoJava

Application performs search request to some search engine. When starts it prompts user to input query string. After user have entered query, application asks to enter search engine name (google or yahoo). Then app make request to selected search engine and display title and url of the first result.

# Realization

I implemented search functionality using factory pattern. This will allow expand amount of search engines easyly.
  ```Searcher``` - interface that declares 'search' method.
  ```GoogleSearcher``` and ```YahooSearcher``` - classes that implement Searcher interface and knoq how to generate request url and parse response.
  ```SearcherFactory``` - class that creates and returns required Searcher implementation
  
  
  ```NetworkUtils``` - class that contain `getContent` method that perform request to the search engine. To receive and parse response I used Jsoup library (https://jsoup.org/).
  
  
To communicate with user I created `ConsoleIO` class that implements `IOInterface` and communicate with user using terminal. `IOInterface` was created to let us easyly add another input/output mechanizm if it is required.
  
  
