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

Overview
==============

Parses CSV dataset and constructs all historical locations in Point Of Interest objects. The MainActivity.java class consists of an interface with Google Maps which produces a Marker at all of the locations of Points of Interests. Users can search for locations, and indicate locations as being on their wishlist or as having been there. Marker colours are adjusted according to these three categories. 

Features
==============
1.French and English translations of location information
2. Differential coloured markers for three separate categories: Default, places users have visited, and places users want to visit

Packages
==============
1. au.com.bytecode.opencsv / contains open source csv parser
2. ca.jchoi.HerritageMapper / contains main application classes 

Todo: Future Expansions
==============

Planned future features include:
- The ability to reach the location information pages from the info window popups on the map interface
- The ability to filter sites by proximity to user
- Routing between sites (finding the optimal path between sites the user is interested in)
- Social connectivity, such as the ability to tag oneself at locations and view other user's tags, as well as leave comments at locations
