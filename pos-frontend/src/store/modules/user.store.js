export default {
  state: {
    isAuthenticated: false,
  },
  getters: {
    getAuthentication(state) {
      return state.isAuthenticated;
    },
  },
  mutations: {
    setAuthentication(state, value) {
      state.isAuthenticated = value;
    },
  },
  actions: {
    VALIDATE_USER({commit},value) {
      commit("setAuthentication", value);
    },
  },
};
