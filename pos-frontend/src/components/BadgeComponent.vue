<template >
    <div>
        <p :class="[ { 'badge--created' : (label === 'Available' || label === 'created'), 'badge--cancelled' : (label === 'Out of Stock' || label === 'canceled')} , 'badge--basic' ]">{{ label }}</p>
    </div>
</template>
<script>
export default {
    name : "BadgeComponent",
    props : {
        label : {
            type : String,
            default : () => {}
        }
    }
}
</script>
<style scoped>
    .badge--basic{
        border-radius:5px;
        padding: 3px 10px;
        text-align: center;
        font-size: 12px;
        font-weight: 700;
        width: fit-content;
        margin: 0;
    }

    .badge--cancelled{
        background-color: #FFE1E7;
        color: #C44F63;
    }

    .badge--created{
        background-color: #D0F4E8;
        color: #22A77C;
    }
</style>