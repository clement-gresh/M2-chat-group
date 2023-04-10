import axios from 'axios';
import { showMessage } from "./status";   
import { ElMessage } from 'element-plus'  

axios.defaults.timeout = 60000;

// @ts-ignore
axios.defaults.baseURL = import.meta.env.VITE_API_DOMAIN;   

//http request 
axios.interceptors.request.use(
  config => {
    config.headers = {
      //'Content-Type':'application/x-www-form-urlencoded',   
      'Content-Type':'application/json;charset=UTF-8',        
      'token':'80c483d59ca86ad0393cf8a98416e2a1'              
    };
    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

//http response 
axios.interceptors.response.use(
  response => {
    return response;
  },
  error => {
    const {response} = error;
    if (response) {
      
      showMessage(response.status);           
      return Promise.reject(response.data);
    } else {
      ElMessage.warning('Exception de Internet, try it later!');
    }
  }
);

export function request(url='',params={},type='POST'){
return new Promise((resolve,reject)=>{
  let promise
  if( type.toUpperCase()==='GET' ){
    promise = axios({
      url,
      params
    })
  }else if( type.toUpperCase()=== 'POST' ){
    promise = axios({
      method:'POST',
      url,
      data:params
    })
  }
  promise.then(res=>{
    resolve(res)
  }).catch(err=>{
    reject(err)
  })
})
}
