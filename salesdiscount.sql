--------------------------------------------------------
--  已建立檔案 - 星期五-六月-30-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table SALESDISCOUNT
--------------------------------------------------------

  CREATE TABLE "MSH"."SALESDISCOUNT" 
   (	"NAME_SALESDISCOUNT" VARCHAR2(100 BYTE), 
	"RECEIPTNO_SALESDISCOUNT" VARCHAR2(20 BYTE), 
	"AMOUNT_SALESDISCOUNT" NUMBER(38,0), 
	"ID_SALESDISCOUNT" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SALESDISCOUNT_PK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "MSH"."SALESDISCOUNT_PK1" ON "MSH"."SALESDISCOUNT" ("RECEIPTNO_SALESDISCOUNT") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table SALESDISCOUNT
--------------------------------------------------------

  ALTER TABLE "MSH"."SALESDISCOUNT" MODIFY ("RECEIPTNO_SALESDISCOUNT" NOT NULL ENABLE);
  ALTER TABLE "MSH"."SALESDISCOUNT" ADD CONSTRAINT "SALESDISCOUNT_PK" PRIMARY KEY ("RECEIPTNO_SALESDISCOUNT")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
