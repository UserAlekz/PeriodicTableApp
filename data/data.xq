for $x in doc("J:\workspace\Periodic Table\data\Wikipedia-Data.xml")/mediawiki/page
where $x
return  <data title="{data($x/title)}" id="{data($x/id)}"/>
