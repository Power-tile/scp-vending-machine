let app = new Vue({
    el: "#app",
    data: {
        activeStep: 0,
    },
    computed: {
        finished: function() {
            return this.activeStep > 2;
        }
    },
    methods: {
        handleNext: function() {
            this.activeStep++;
        },
        handlePrev: function() {
            this.activeStep--;
        }
    }
});