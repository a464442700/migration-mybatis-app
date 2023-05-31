
  CREATE OR REPLACE EDITIONABLE PACKAGE "APPS"."CUX_TABLE_PVT" is

  function get_name(p_id in number) return varchar2;
  
end   cux_table_pvt;
/
CREATE OR REPLACE EDITIONABLE PACKAGE BODY "APPS"."CUX_TABLE_PVT" is

  function get_name(p_id in number) return varchar2 is
    l_name varchar2(240);
  l_cux_table_tbl  apps.cux_table_tbl_type;
    
  begin
    SELECT 1 INTO  L_NAME FROM DUAL;
    SELECT 1 INTO  L_NAME FROM cux.cux_table@dblink_standby;
    select name into l_name from cux_table_v where id = p_id;
    return l_name;
  exception
    when others then
      print(sqlerrm);
      return null;
  end get_name;

end cux_table_pvt;
