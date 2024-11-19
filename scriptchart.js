class ChartBase {
  constructor(ctx, platforms, usersData) {
    this.ctx = ctx;
    this.platforms = platforms;
    this.usersData = usersData;
  }

  createChart() {
    throw new Error("createChart() must be implemented by subclasses");
  }
}

class BarChart extends ChartBase {
  createChart() {
    new Chart(this.ctx, {
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
          borderColor: ['black'],
          borderWidth: 1
        }]
      },
      options: { scales: { y: { beginAtZero: true } } }
    });
  }
}

class PieChart extends ChartBase {
  createChart() {
    new Chart(this.ctx, {
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
          borderColor: ['black'],
          borderWidth: 1
        }]
      },
      options: { responsive: true, plugins: { legend: { position: 'bottom' } } }
    });
  }
}

class LineChart extends ChartBase {
  createChart() {
    new Chart(this.ctx, {
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
}

class AreaChart extends ChartBase {
  createChart() {
    new Chart(this.ctx, {
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

class ChartManager {
  #dataUrl;
  #platforms = [];
  #usersData = [];

  constructor(dataUrl) {
    this.#dataUrl = dataUrl;
  }

  async fetchData() {
    try {
      const response = await fetch(this.#dataUrl);
      if (!response.ok) {
        throw new Error('Network response was not ok ' + response.statusText);
      }
      const data = await response.json();
      this.#platforms = data.platforms;
      this.#usersData = data.data;
    } catch (error) {
      console.error('Fetch error:', error);
    }
  }

  initializeCharts() {
    const barChart = new BarChart(document.getElementById('myChart'), this.#platforms, this.#usersData);
    barChart.createChart();

    const pieChart = new PieChart(document.getElementById('pieChart'), this.#platforms, this.#usersData);
    pieChart.createChart();

    const lineChart = new LineChart(document.getElementById('lineChart'), this.#platforms, this.#usersData);
    lineChart.createChart();

    const areaChart = new AreaChart(document.getElementById('areaChart'), this.#platforms, this.#usersData);
    areaChart.createChart();
  }
}

const chartManager = new ChartManager('datachart.json');
chartManager.fetchData().then(() => chartManager.initializeCharts());
