import Vue from 'vue'
import Router from 'vue-router'
import Map from '@/router/pages/Map'
import AddMevlut from '@/router/pages/AddMevlut'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Map',
      component: Map
    },
    {
      path: '/add-mevlut',
      name: 'AddMevlut',
      component: AddMevlut
    }
  ]
})
