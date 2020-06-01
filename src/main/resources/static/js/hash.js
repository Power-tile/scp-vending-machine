let hash = new Vue({
    el: "#hash",
    data: {
        hashCode: "Not Generated Yet"
    },
    mounted() {
        let date = new Date().toISOString();
        this.hashCode = md5(date);
    }
});