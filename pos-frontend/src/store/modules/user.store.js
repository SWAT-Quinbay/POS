export default{
state:{
   isAuthenticated:false
 },
 getters:
 {
  getAuthentication(state) 
     {
      return state.isAuthenticated;
     },

 },
 mutations:
 {
     setAuthentication(state,value)
     {
      state.isAuthenticated=value;
     },
 },
 actions:
 {
           validateUser(value)
           {
               this.commit('setAuthentication',value);
           }
}
}