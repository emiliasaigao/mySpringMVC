
window.onload=function() {
    var vue = new Vue({
        el:"#employee_table",
        methods:{
            deleteEmployee : function (event) {
                var deleteFrom = document.getElementById("deleteEmployee");
                deleteFrom.action = event.target.href;
                deleteFrom.submit();
                event.preventDefault();
            }
        }
    });
};

