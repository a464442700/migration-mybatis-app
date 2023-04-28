
  CREATE OR REPLACE EDITIONABLE PROCEDURE "APPS"."PRINT" (P_string in varchar2) is
begin
 dbms_output.put_line(P_string);
end;
