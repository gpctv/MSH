INSERT INTO "MSH"."DISCOUNT" (ID_DISCOUNT, TYPE_DISCOUNT, AMOUNT_DISCOUNT, NAME_DISCOUNT, ENABLE_ITEM) 
VALUES (2, 'posKey3', 0.3, '¤C§é', 1);

select *
from msh.discount;

select *
from msh.item ;
 
select * 
from(
select t.*,ROWNUM r
from 
(select  name_discount title,'discount' type,amount_discount discount,0 sales,enable_discount  isEnable,id_discount id
from msh.discount
union
select name_item title,'item' type,0 discount,amount_item sales,enable_item  isEnable, id_item id
from msh.item ) t
)  order by r

where R=3
;
 select nvl(max(id_discount),0)+1
from msh.discount  ;

select *
from SALESITEM;
select *
from salesdiscount;
 