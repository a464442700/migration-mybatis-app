
  CREATE OR REPLACE EDITIONABLE PACKAGE "APPS"."CUX_TABLE_PUB" is

  function get_name(p_id in number) return varchar2 ;
end cux_table_pub ;
/
CREATE OR REPLACE EDITIONABLE PACKAGE BODY "APPS"."CUX_TABLE_PUB" is


  function get_name(p_id in number) return varchar2 is
    begin
      return cux_table_pvt.get_name(p_id);
    end;
end ;
