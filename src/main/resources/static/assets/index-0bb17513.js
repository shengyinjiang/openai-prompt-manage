import{Z as e}from"./index-a4efef0e.js";const t=((t,s)=>{const r=e.create({baseURL:t,headers:{source:s},withCredentials:!0,timeout:36e3});return r.interceptors.request.use((e=>(e.headers={...e.headers,"Content-Type":"application/json",token:localStorage.getItem("token")||"eyJhbGciOiJIUzUxMiJ9.eyJvcmdJZCI6ImRjOWRlMzkxLWU0ZTktNDcwNC1hODgxLWJhN2I3NGEzN2U1NyIsInVzZXJJZCI6IjJmYTQwOWU4LTg0MWEtNDAzMy05NzJjLWNlNWIyZjA3NDU1MyIsImNsdXN0ZXJJZCI6InYyZGV2IiwiZXhwIjoxNjcyOTkxNzQyfQ.0BdKvhfVzrrJyC62LAX6R4BYY07Tk3ni8RvQ3X9LIe1HleSnHHX8Q1OR7A8Bd8RvwPQ2hzOdPRVlsxtQ6pi5dw"},e)),(e=>Promise.reject(e))),r.interceptors.response.use((e=>200===e.status||201===e.status?e.data:Promise.reject("")),(e=>Promise.reject(e))),r})("/api"),s=e=>(Object.assign(e,{orderBy:"createTime"}),t.post("/prompts/list",e)),r=e=>t.get("/prompts/detail",{params:e}),a=e=>t.delete("/prompts/delete",{data:{promptIds:e}}),o=e=>t.put("/prompts/add",{createUserId:"string",createUserName:"string",prompts:[e.prompts]});export{o as a,r as b,a as d,s as q};
