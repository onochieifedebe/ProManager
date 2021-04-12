
var readableChartData = decodeHtml(chartData);
var jsonArray = JSON.parse(readableChartData);


var valueData = [];
var labelData = [];

for(var i = 0; i< jsonArray.length; i++){
	valueData[i] = jsonArray[i].value;
	labelData[i] = jsonArray[i].label;
}

new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#00FF00","#3e95cd","#FF6347"],
            data: valueData,
        }]
    },

    // Configuration options go here
    options: {
		title: {
			display: true,
			text: 'Project Status'
		}
	}
});

function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}