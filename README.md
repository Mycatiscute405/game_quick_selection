#include <iostream>
using namespace std

main()
{
  // skill used
  string frontend[] = {"VSCode", "HTML5", "CSS3", "JavaScript", "Vuejs", "SCSS"};
  string backend[] = {"Eclipse", "SpringBoot", "JPA"};
  
  // skill to be used in the future
  // frontend ---> axios
  // backend ---> db(oracle or mySQL), querydsl
  
  int size = sizeof(frontend) > sizeof(backend) ? sizeof(frontend) : sizeof(backend);
  
  for(int idx = 0; idx < size; idx++)
  {
    cout << frontend[idx] << endl;
    cout << backend[idx] << endl;
  }
}
