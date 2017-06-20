--------------------------------------------------------
--  �w�إ��ɮ� - �P���G-����-20-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table SALESITEM
--------------------------------------------------------

  CREATE TABLE "MSH"."SALESITEM" 
   (	"RECEIPTNO_SALESITEM" VARCHAR2(10 BYTE), 
	"ID_SALESITEM" NUMBER(15,0), 
	"ITEM_SALESITEM" VARCHAR2(100 BYTE), 
	"COUNT_SALESITEM" NUMBER(15,0), 
	"AMOUNT_SALESITEM" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SALESITEM_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "MSH"."SALESITEM_PK" ON "MSH"."SALESITEM" ("RECEIPTNO_SALESITEM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table SALESITEM
--------------------------------------------------------

  ALTER TABLE "MSH"."SALESITEM" MODIFY ("RECEIPTNO_SALESITEM" NOT NULL ENABLE);
  ALTER TABLE "MSH"."SALESITEM" ADD CONSTRAINT "SALESITEM_PK" PRIMARY KEY ("RECEIPTNO_SALESITEM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;