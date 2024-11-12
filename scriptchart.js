class ChartManager {
    constructor(dataUrl) {
      this.dataUrl = dataUrl;
      this.platforms = [];
      this.usersData = [];
    }
  

    async fetchData() {
      try {
        const response = await fetch(this.dataUrl);
        if (!response.ok) {
          throw new Error('Network response was not ok ' + response.statusText);
        }
        const data = await response.json();
        this.platforms = data.platforms;
        this.usersData = data.data;
      } catch (error) {
        console.error('Fetch error:', error);
      }
    }
  
   
    initializeCharts() {
      this.createBarChart();
      this.createPieChart();
      this.createLineChart();
      this.createAreaChart();
    }
  

    createBarChart() {
      const barCtx = document.getElementById('myChart');
      new Chart(barCtx, {
        type: 'bar',
        data: {
          labels: this.platforms,
          datasets: [{
            label: 'Number of Users (millions)',
            data: this.usersData,
            backgroundColor: [
              'rgba(255, 99, 132, 0.2)', 'rgba(54, 162, 235, 0.2)',
              'rgba(255, 206, 86, 0.2)', 'rgba(75, 192, 192, 0.2)',
              'rgba(153, 102, 255, 0.2)'
            ],
            borderColor: [
            `black`
            ],
            borderWidth: 1
          }]
        },
        options: { scales: { y: { beginAtZero: true } } }
      });
    }
  

    createPieChart() {
      const pieCtx = document.getElementById('pieChart');
      new Chart(pieCtx, {
        type: 'pie',
        data: {
          labels: this.platforms,
          datasets: [{
            label: 'Number of Users (millions)',
            data: this.usersData,
            backgroundColor: [
              'rgba(255, 99, 132, 0.2)', 'rgba(54, 162, 235, 0.2)',
              'rgba(255, 206, 86, 0.2)', 'rgba(75, 192, 192, 0.2)',
              'rgba(153, 102, 255, 0.2)'
            ],
            borderColor: [
              `black`
            ],
            borderWidth: 1
          }]
        },
        options: { responsive: true, plugins: { legend: { position: 'bottom' } } }
      });
    }
  

    createLineChart() {
      const lineCtx = document.getElementById('lineChart');
      new Chart(lineCtx, {
        type: 'line',
        data: {
          labels: this.platforms,
          datasets: [{
            label: 'Number of Users (millions)',
            data: this.usersData,
            borderColor: 'black',
            backgroundColor: 'rgba(75, 192, 192, 0.2)',
            fill: false,
            borderWidth: 2
          }]
        },
        options: { scales: { y: { beginAtZero: true } } }
      });
    }

    createAreaChart() {
      const areaCtx = document.getElementById('areaChart');
      new Chart(areaCtx, {
        type: 'line',
        data: {
          labels: this.platforms,
          datasets: [{
            label: 'Number of Users (millions)',
            data: this.usersData,
            borderColor: 'black',
            backgroundColor: 'rgba(54, 162, 235, 0.2)',
            fill: true,
            borderWidth: 2
          }]
        },
        options: { scales: { y: { beginAtZero: true } } }
      });
    }
  }
  
 
  const chartManager = new ChartManager('datachart.json');
  chartManager.fetchData().then(() => chartManager.initializeCharts());
  