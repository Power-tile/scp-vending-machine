let app = new Vue({
    el: "#app",
    data: {
        step: 0,
        rawProducts: [
            // {"id":1,"name":"HOH","price":1.0,"productionDate":"2020-05-03T16:00:00.000+00:00","expiryDate":"2025-05-02T16:00:00.000+00:00","status":1,"random":0,"slot":1,"test":1,"imageUrl":"/api/img/cbac5ec09975c55d3974805071f53d4a.png"},
            // {"id":9,"name":"HOH","price":1.0,"productionDate":"2020-05-03T16:00:00.000+00:00","expiryDate":"2025-05-02T16:00:00.000+00:00","status":1,"random":0,"slot":1,"test":1,"imageUrl":"/api/img/cbac5ec09975c55d3974805071f53d4a.png"},
            // {"id":2,"name":"HClO","price":10.0,"productionDate":"2020-03-04T16:00:00.000+00:00","expiryDate":"2029-06-23T16:00:00.000+00:00","status":1,"random":0,"slot":10,"test":1,"imageUrl":"/api/img/66effb0ecc59268ea02bce9c48b6bd2e.jpg"},
            // {"id":4,"name":"Ethanol","price":15.0,"productionDate":"2020-03-08T16:00:00.000+00:00","expiryDate":"2022-04-06T16:00:00.000+00:00","status":1,"random":1,"slot":4,"test":1,"imageUrl":"/api/img/0544bb84e9d73e12f3adc68ee2078495.jpg"},
            // {"id":4,"name":"A","price":15.0,"productionDate":"2020-03-08T16:00:00.000+00:00","expiryDate":"2022-04-06T16:00:00.000+00:00","status":1,"random":1,"slot":4,"test":1,"imageUrl":"/api/img/0544bb84e9d73e12f3adc68ee2078495.jpg"},
            // {"id":4,"name":"AA","price":15.0,"productionDate":"2020-03-08T16:00:00.000+00:00","expiryDate":"2022-04-06T16:00:00.000+00:00","status":1,"random":1,"slot":4,"test":1,"imageUrl":"/api/img/0544bb84e9d73e12f3adc68ee2078495.jpg"},
            // {"id":4,"name":"AAA","price":15.0,"productionDate":"2020-03-08T16:00:00.000+00:00","expiryDate":"2022-04-06T16:00:00.000+00:00","status":1,"random":1,"slot":4,"test":1,"imageUrl":"/api/img/0544bb84e9d73e12f3adc68ee2078495.jpg"},
            // {"id":4,"name":"A A","price":15.0,"productionDate":"2020-03-08T16:00:00.000+00:00","expiryDate":"2022-04-06T16:00:00.000+00:00","status":1,"random":1,"slot":4,"test":1,"imageUrl":"/api/img/0544bb84e9d73e12f3adc68ee2078495.jpg"},
            // {"id":4,"name":"AAA","price":15.0,"productionDate":"2020-03-08T16:00:00.000+00:00","expiryDate":"2022-04-06T16:00:00.000+00:00","status":1,"random":1,"slot":4,"test":1,"imageUrl":"/api/img/0544bb84e9d73e12f3adc68ee2078495.jpg"},
            // {"id":4,"name":"AA","price":15.0,"productionDate":"2020-03-08T16:00:00.000+00:00","expiryDate":"2022-04-06T16:00:00.000+00:00","status":1,"random":1,"slot":4,"test":1,"imageUrl":"/api/img/0544bb84e9d73e12f3adc68ee2078495.jpg"},
            // {"id":4,"name":"AAAA","price":15.0,"productionDate":"2020-03-08T16:00:00.000+00:00","expiryDate":"2022-04-06T16:00:00.000+00:00","status":1,"random":1,"slot":4,"test":1,"imageUrl":"/api/img/0544bb84e9d73e12f3adc68ee2078495.jpg"},
            // {"id":4,"name":"AAAA","price":15.0,"productionDate":"2020-03-08T16:00:00.000+00:00","expiryDate":"2022-04-06T16:00:00.000+00:00","status":1,"random":1,"slot":4,"test":1,"imageUrl":"/api/img/0544bb84e9d73e12f3adc68ee2078495.jpg"},
        ],
        randomBox: {
            // name: "Mock Random Box",
            // ids: [99, 100, 101],
            // price: 3.5,
            // imageUrl: "/api/img/96d4aef90820265861855512ea9f4164.png",
            // test: 1
        },
        selectCount: [],
        addWarning: [],
        minusWarning: [],
        headerBarHeight: 0,
        footerBarHeight: 0,
    },
    mounted: function() {
        let self = this;
        
        $.ajax({
            url: "/api/product/test/available", // TODO change to prod url
            contentType: "application/json",
            success: function(data) {
                self.rawProducts = data.products;
                self.randomBox = data.randomBox;

                for (let i = 0; i < self.viewProducts.length; i++) {
                    self.selectCount.push(0);
                    self.addWarning.push(false);
                    self.minusWarning.push(false);
                }
                self.headerBarHeight = self.$refs.headerBar.offsetHeight;
                self.footerBarHeight = self.$refs.footerBar.offsetHeight;
            }
        });
    },
    computed: {
        viewProducts: function() {
            if (this.rawProducts.length) {
                let map = new Map();
                for (let index = 0; index < this.rawProducts.length; index++) {
                    let product = this.rawProducts[index];
                    let key = JSON.stringify({
                        name: product.name,
                        price: product.price,
                        imageUrl: product.imageUrl
                    });

                    if (map.get(key) === undefined) map.set(key, [ product.id ]);
                    else {
                        let value = map.get(key).concat([ product.id ]);
                        map.set(key, value);
                    }
                }
                let ret = Array.from(map).reduce(function(prev, curr) { return prev.concat([[ JSON.parse(curr[0]), curr[1] ]]); }, [])
                ret.push([{
                    name: this.randomBox.name,
                    price: this.randomBox.price,
                    imageUrl: this.randomBox.imageUrl
                }, this.randomBox.ids]);
                return ret;
            } else {
                return [];
            }
        },
        totalPrice: function() {
            let self = this;
            let ret = this.viewProducts.reduce((prev, curr, index) => {
                return prev + curr[0].price * self.selectCount[index];
            }, 0)
            return ret;
        }
    },
    methods: {
        handleMinusAction: function(event) {
            let index = event.currentTarget.name;
            let val = this.selectCount[index];
            if (val > 0) {
                this.$set(this.selectCount, index, val-1);
            } else {
                this.$set(this.minusWarning, index, true);
                let self = this;
                setTimeout(() => { self.$set(self.minusWarning, index, false) }, 1000);
            }
        },
        handleAddAction: function(event) {
            let index = event.currentTarget.name;
            let val = this.selectCount[index];
            if (val < this.viewProducts[index][1].length) {
                this.$set(this.selectCount, index, val+1);
            } else {
                this.$set(this.addWarning, index, true);
                let self = this;
                setTimeout(() => { self.$set(self.addWarning, index, false) }, 1000);
            }
        }
    }
});