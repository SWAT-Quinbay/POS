<template>
    <button :type="type" @click="onClick()" :class="buttonStyle">{{ label }}</button>
</template>
<script>
export default {
    name : "ButtonComponent",
    props : {
        label : {
            type : String,
            default : "Submit",
        },
        type : {
            type : String,
            default : "button"
        },
        buttonStyle : {
            type : String,
            default : "btn--primary"
        }
    },
    methods : {
        onClick(){
            this.$emit('onClick')
        }
    }
}
</script>
<style scoped>
    .btn--primary{
        color: white;
        border: 1px solid #ffffff;
        border: none;
        outline: none;
        width: 100%;
        height: 35px;
        font-size: 14px;
        font-weight: 700;
        border-radius: 10px;
        padding: 5px 15px;
        margin-top: 20px;
        background-color: #1C3584;
    }

    .btn--primary--outline{
        color: #1C3584;
        border: 1px solid #1C3584;
        width: 100%;
        height: 35px;
        font-size: 14px;
        font-weight: 700;
        border-radius: 10px;
        padding: 5px 15px;
        margin-top: 20px;
        background-color: #ffffff;
    }

</style>