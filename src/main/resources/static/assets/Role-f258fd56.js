import{_ as e}from"./ContentWrap.vue_vue_type_script_setup_true_lang-7d720f0a.js";import{d as a,k as s,$ as r,r as t,o,h as l,w as i,g as m,a as n,S as p,t as u}from"./index-a4efef0e.js";import{_ as d}from"./Table.vue_vue_type_script_lang-bc702329.js";import{g as _}from"./index-27fab35e.js";import{E as f}from"./el-button-5e3ca3eb.js";import"./el-popper-5af16893.js";import"./index-b9ec11c4.js";import"./tsxHelper-d30ca50a.js";import"./el-input-763158f1.js";import"./el-tag-79e961c8.js";const c=a({__name:"Role",setup(a){const{t:c}=s(),g=[{field:"index",label:c("userDemo.index"),type:"index"},{field:"username",label:c("userDemo.username")},{field:"password",label:c("userDemo.password")},{field:"role",label:c("userDemo.role")},{field:"remark",label:c("userDemo.remark"),formatter:e=>r("span","admin"===e.username?c("userDemo.remarkMessage1"):c("userDemo.remarkMessage2"))},{field:"action",label:c("userDemo.action")}],D=t(!0);let j=t([]);(async e=>{const a=await _({params:e||{pageIndex:1,pageSize:10}});a&&(j.value=a.data.list,D.value=!1)})();return(a,s)=>(o(),l(n(e),{title:n(c)("userDemo.title"),message:n(c)("userDemo.message")},{default:i((()=>[m(n(d),{columns:g,data:n(j),loading:D.value,selection:!1},{action:i((e=>[m(n(f),{type:"primary",onClick:e=>{}},{default:i((()=>[p(u(n(c)("tableDemo.action")),1)])),_:2},1032,["onClick"])])),_:1},8,["data","loading"])])),_:1},8,["title","message"]))}});export{c as default};
