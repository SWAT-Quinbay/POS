<template>
    <button :type="type" @click="onClick()" :class="buttonStyle" :disabled="disabled">{{ label }}</button>
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
        },
        disabled : {
            type : Boolean,
            default : false
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
        background-color: #FF6665;
    }

    .btn--primary--outline{
        color: #FF6665;
        border: 1px solid #FF6665;
        width: 100%;
        height: 35px;
        font-size: 14px;
        font-weight: 700;
        border-radius: 10px;
        padding: 5px 15px;
        background-color: #ffffff;
    }

    .btn--danger{
        color: white;
        border: 1px solid #ffffff;
        border: none;
        outline: none;
        /* width: 100%; */
        height: 30px;
        font-size: 13px;
        font-weight: 700;
        border-radius: 10px;
        padding: 5px 15px;
        background-color: #DC3545;
    }

    .btn--secondary{
        color: white;
        border: 1px solid #ffffff;
        border: none;
        outline: none;
        /* width: 100%; */
        height: 30px;
        font-size: 13px;
        font-weight: 700;
        border-radius: 10px;
        padding: 5px 15px;
        background-color: #a4a4a4;
    }

    .btn--disabled{
        color: white;
        border: 1px solid #ffffff;
        border: none;
        outline: none;
        /* width: 100%; */
        height: 30px;
        font-size: 13px;
        font-weight: 700;
        border-radius: 10px;
        padding: 5px 15px;
        background-color: #dfdfdf;
    }

</style>