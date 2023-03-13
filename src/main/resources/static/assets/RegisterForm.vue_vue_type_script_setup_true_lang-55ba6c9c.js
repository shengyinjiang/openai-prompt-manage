import{u as e,F as o}from"./useForm-e296b64d.js";import{d as s,V as l,r as a,o as r,h as t,w as n,e as d,t as i,a as c,g as p,S as m,k as u}from"./index-a4efef0e.js";import{E as g}from"./el-button-5e3ca3eb.js";import{E as h}from"./el-input-763158f1.js";import{u as w}from"./useValidator-d3f5ebd5.js";const f={class:"text-2xl font-bold text-center w-[100%]"},P={class:"w-[100%] flex"},b={class:"w-[100%]"},v={class:"w-[100%] mt-15px"},k=s({__name:"RegisterForm",emits:["to-login"],setup(s,{emit:k}){const{register:y,elFormRef:_}=e(),{t:x}=u(),{required:V}=w(),j=l([{field:"title",colProps:{span:24}},{field:"username",label:x("login.username"),value:"",component:"Input",colProps:{span:24},componentProps:{placeholder:x("login.usernamePlaceholder")}},{field:"password",label:x("login.password"),value:"",component:"InputPassword",colProps:{span:24},componentProps:{style:{width:"100%"},strength:!0,placeholder:x("login.passwordPlaceholder")}},{field:"check_password",label:x("login.checkPassword"),value:"",component:"InputPassword",colProps:{span:24},componentProps:{style:{width:"100%"},strength:!0,placeholder:x("login.passwordPlaceholder")}},{field:"code",label:x("login.code"),colProps:{span:24}},{field:"register",colProps:{span:24}}]),F={username:[V()],password:[V()],check_password:[V()],code:[V()]},R=()=>{k("to-login")},q=a(!1),I=async()=>{const e=c(_);null==e||e.validate((async e=>{if(e)try{q.value=!0,R()}finally{q.value=!1}}))};return(e,s)=>(r(),t(c(o),{schema:j,rules:F,"label-position":"top","hide-required-asterisk":"",size:"large",class:"dark:border-1 dark:border-[var(--el-border-color)] dark:border-solid",onRegister:c(y)},{title:n((()=>[d("h2",f,i(c(x)("login.register")),1)])),code:n((e=>[d("div",P,[p(c(h),{modelValue:e.code,"onUpdate:modelValue":o=>e.code=o,placeholder:c(x)("login.codePlaceholder")},null,8,["modelValue","onUpdate:modelValue","placeholder"])])])),register:n((()=>[d("div",b,[p(c(g),{type:"primary",class:"w-[100%]",loading:q.value,onClick:I},{default:n((()=>[m(i(c(x)("login.register")),1)])),_:1},8,["loading"])]),d("div",v,[p(c(g),{class:"w-[100%]",onClick:R},{default:n((()=>[m(i(c(x)("login.hasUser")),1)])),_:1})])])),_:1},8,["schema","onRegister"]))}});export{k as _};
