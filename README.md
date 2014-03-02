Canadian Heritage Mapper
==============

               ,
               }`-.   ,          ,
               \ \ '-' \      .-'{
               _} .  | ,`\   /  ' ;    .-;\
              {    \ |    | / `/  '-.,/ ; |
              { -- -.  '  '`-, .--._.' ;  \__
               \     \ | '  /  |`.    ;    _,`\
                '. '-     ' `_- '.`;  ; ,-`_.-'
            ,--.  \    `   /` '--'  `;.` (`  _
         .--.\  '._) '-. \ \ `-.    ;     `-';|
         '. -. '         __ '.  ;  ;     _,-' /
          { __'.\  ' '-,/; `-'   ';`.- `   .-'
           '-.  `-._'  | `;     ;`'   .-'`
             <_ -'   ` .\  `;  ;     (_.'`\
             _.;-"``"'-._'. `:;  ___, _.-' |
         .-'\'. '.` \ \_,_`\ ;##`   `';  _.'
        /_'._\ \  \__;#####./###.      \`
        \.' .'`/"`/ (#######)###::.. _.'
         '.' .'  ; , |:.  `|()##`"""` 
       jgs `'-../__/_\::   /O()()o
                    ()'._.'`()()'
                    

The Heritage Mapper Android Application provides an opportunity for Canadians to discover more about our country by highlighting the location of historical sites designated by the Federal Park's Department. It allows users the ability to select locations they've already visited and those they wish to visit, so as to keep track of their federal historical site experiences. 



Authors
==============
1. Angela Chen, angelaichen87@gmail.com, UBC
2. Woong Gung Choi, woonggun@jchoi.ca, UBC
3. Laura Tammpere, laura.tammpere@gmail.com, UBC
4. Roxanne Taylor, roxanne.e.taylor@gmail.com, UBC
  

Data
==============
The Heritage Mapper is powered by Park's Department Federal Heritage Destinations, National Historic Site's dataset (http://data.gc.ca/data/en/dataset/b8c61621-e541-4e4c-8654-48152519a30a)

Components
==============

Packages:
1. au.com.bytecode.opencsv
Contains an open-source CSV reader and writer

2. ca.jchoi.HerritageMapper
Contains...
...MainActivity.java, which consists of a Google Maps interface.
...HeritageMapper.java, which parses the Parks Canada data
...LocationInfoActivity.java, which summarizes the basic information about each location, such as city, and a description of the historical site's designation
...ParsedPointOfINterest.java, which contains the fields, setters, and getters of the historical location object
...Search


Future Expansions
==============

Planned future features include:
- The ability to filter sites by proximity to user
- Routing between sites (finding the optimal path between sites the user is interested in)
- Social connectivity, such as the ability to tag oneself at locations and view other user's tags, as well as leave comments at locations
