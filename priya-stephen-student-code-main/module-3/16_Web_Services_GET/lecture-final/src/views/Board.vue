<template>
  <cards-list :board-id="$route.params.id"/>
</template>

<script>
import CardsList from '../components/CardsList';

export default {
  components: {
    CardsList
  }
};
</script>
