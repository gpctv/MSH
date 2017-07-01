--------------------------------------------------------
--  已建立檔案 - 星期六-七月-01-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ID
--------------------------------------------------------

  CREATE TABLE "MSH"."ID" 
   (	"RECEIPTNO_ID" VARCHAR2(20 BYTE), 
	"ID_ID" NUMBER(15,0), 
	"CREATEDATE_ID" DATE, 
	"CREATETIME_ID" TIMESTAMP (6)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index ID_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "MSH"."ID_PK" ON "MSH"."ID" ("RECEIPTNO_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table ID
--------------------------------------------------------

  ALTER TABLE "MSH"."ID" MODIFY ("RECEIPTNO_ID" NOT NULL ENABLE);
  ALTER TABLE "MSH"."ID" ADD CONSTRAINT "ID_PK" PRIMARY KEY ("RECEIPTNO_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
