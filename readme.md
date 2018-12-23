1) Call any get method to generate the import.sql script
                
2) Get information about a person or company (address, hobbies etc) given a phone number<br />
    localhost:port/api/infoEntity/number<br />
    ex. http://localhost:8081/api/infoEntity/7482992

3) Get all persons with a given hobby<br />
    localhost:port/api/person/hobby/hobbyName<br />
    ex. http://localhost:8081/api/person/hobby/fishing 
    
4) Get all persons living in a given city<br />
    localhost:port/api/person/city/zipcode<br />
    ex. http://localhost:8081/api/person/city/555   
    
5) Get the count of people with a given hobby<br />
    localhost:port/api/person/hobby/count/hobbyName<br />
    ex. http://localhost:8081/api/person/hobby/count/fishing  
    
6) Get a list of all zip codes in denmark<br />
  localhost:port/api/cityInfo/nation/zipcodes<br />
  ex.http://localhost:8081/api/cityInfo/denmark/zipcodes
  
7) Get a list of companies with more than xx employes<br />
  localhost:port/api/company/employees/amountOfEmployees<br />
  ex. http://localhost:8081/api/company/employees/15