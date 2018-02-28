<template>
  <div id="app" style="height: 100%">
    <b-navbar toggleable="md" type="dark" variant="dark">
      <b-navbar-toggle target="router"></b-navbar-toggle>
      <b-navbar-brand to="/">mevludumnerde.com</b-navbar-brand>
      <b-collapse is-nav id="router">
        <b-navbar-nav>
          <b-nav-item to="/">Harita</b-nav-item>
          <b-nav-item to="/add-mevlut">Mevlut Ekle</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
    <router-view class="view"></router-view>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
/* @import 'reset-css/reset.css'; */

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}
</style>
