import{$ as s,b7 as e,d as a,aA as l,B as o,s as n,o as t,c,e as i,v as r,n as u,a as p,h as d,w as f,g as k,c1 as g,bN as m,E as y,y as b,z as v,i as C,_ as h,K as _}from"./index-fd4ebc93.js";const B=s({closable:Boolean,type:{type:String,values:["success","info","warning","danger",""],default:""},hit:Boolean,disableTransitions:Boolean,color:{type:String,default:""},size:{type:String,values:e,default:""},effect:{type:String,values:["dark","light","plain"],default:"light"},round:Boolean}),E={close:s=>s instanceof MouseEvent,click:s=>s instanceof MouseEvent},S=a({name:"ElTag"});const $=_(h(a({...S,props:B,emits:E,setup(s,{emit:e}){const a=s,h=l(),_=o("tag"),B=n((()=>{const{type:s,hit:e,effect:l,closable:o,round:n}=a;return[_.b(),_.is("closable",o),_.m(s),_.m(h.value),_.m(l),_.is("hit",e),_.is("round",n)]})),E=s=>{e("close",s)},S=s=>{e("click",s)};return(s,e)=>s.disableTransitions?(t(),c("span",{key:0,class:u(p(B)),style:v({backgroundColor:s.color}),onClick:S},[i("span",{class:u(p(_).e("content"))},[r(s.$slots,"default")],2),s.closable?(t(),d(p(y),{key:0,class:u(p(_).e("close")),onClick:m(E,["stop"])},{default:f((()=>[k(p(g))])),_:1},8,["class","onClick"])):b("v-if",!0)],6)):(t(),d(C,{key:1,name:`${p(_).namespace.value}-zoom-in-center`,appear:""},{default:f((()=>[i("span",{class:u(p(B)),style:v({backgroundColor:s.color}),onClick:S},[i("span",{class:u(p(_).e("content"))},[r(s.$slots,"default")],2),s.closable?(t(),d(p(y),{key:0,class:u(p(_).e("close")),onClick:m(E,["stop"])},{default:f((()=>[k(p(g))])),_:1},8,["class","onClick"])):b("v-if",!0)],6)])),_:3},8,["name"]))}}),[["__file","/home/runner/work/element-plus/element-plus/packages/components/tag/src/tag.vue"]]));export{$ as E,B as t};
