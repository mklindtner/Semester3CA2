1) Call any get method to generate the import.sql script
                
2) Get information about a person or company (address, hobbies etc) given a phone number
    localhost:port/api/infoEntity/number
    ex. http://localhost:8081/api/infoEntity/7482992

3) Get all persons with a given hobby
    localhost:port/api/person/hobby/hobbyName
    ex. http://localhost:8081/api/person/hobby/fishing   
    
4) Get all persons living in a given city
    localhost:port/api/person/city/zipcode
    ex. http://localhost:8081/api/person/city/555   
    
5) Get the count of people with a given hobby
    localhost:port/api/person/hobby/count/hobbyName
    ex. http://localhost:8081/api/person/hobby/count/fishing  
    
6) Get a list of all zip codes in denmark
  localhost:port/api/cityInfo/nation/zipcodes
  ex. http://localhost:8081/api/cityInfo/denmark/zipcodes
  
7) Get a list of companies with more than xx employes
  localhost:port/api/company/employees/amountOfEmployees
  ex. http://localhost:8081/api/company/employees/15