<template>
  <gmap-map
    :center="center"
    :zoom="12"
    @click="helloworld"
    :options="{disableDefaultUI:false}"
    style="width: 100%; height: calc(100% - 56px)">
    <gmap-marker
      :key="index"
      v-for="(m, index) in mevluts"
      :position="m.position"
      :clickable="true"
      :draggable="false"
      @click="center=m.position"
    ></gmap-marker>
  </gmap-map>
</template>

<script>
import 'vue-awesome/icons'
import Icon from 'vue-awesome/components/Icon'

export default {
  name: 'Map',
  data () {
    return {
      center: {lat: 38.3292676, lng: 26.6414996},
      mevluts: [{ position: {lat: 38.3292676, lng: 26.6414996} }]
    }
  },
  mounted: function () {
    this.geolocation()
    this.getMevluts()
  },
  methods: {
    helloworld: () => {
      console.log('sa!')
    },
    geolocation: function () {
      navigator.geolocation.getCurrentPosition((position) => {
        this.currentLocation = {
          lat: position.coords.latitude,
          lng: position.coords.longitude
        }
      })
    },
    getMevluts: function () {
      console.log(process.env.SERVER_URI + '/mevluts')
      this.$http.get(process.env.SERVER_URI + '/mevluts').then(function (res) {
        this.mevluts = res.body
      }, function (error) {
        console.error('getMevluts error:' + error)
      })
    }
  },
  components: {
    Icon
  }
}
</script>

<style scoped>

</style>
