const barCtx = document.getElementById('myChart');
const pieCtx = document.getElementById('pieChart');
const lineCtx = document.getElementById('lineChart'); 
const areaCtx = document.getElementById('areaChart'); 

fetch('datachart.json')
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok ' + response.statusText);
    }
    return response.json();
  })
  .then(data => {
  
    const platforms = ['Viber', 'Discord', 'WhatsApp', 'Telegram', 'Messenger'];
    const usersData = data.data;

    
    new Chart(barCtx, {
        type: 'bar',
        data: {
          labels: platforms,
          datasets: [{
            label: 'Number of Users (millions)',
            data: usersData,
            backgroundColor: [
              'rgba(255, 99, 132, 0.2)',   
              'rgba(54, 162, 235, 0.2)',  
              'rgba(255, 206, 86, 0.2)',  
              'rgba(75, 192, 192, 0.2)',  
              'rgba(153, 102, 255, 0.2)'  
            ],
            borderColor: [
              'rgba(255, 99, 132, 1)',   
              'rgba(54, 162, 235, 1)',    
              'rgba(255, 206, 86, 1)',    
              'rgba(75, 192, 192, 1)',    
              'rgba(153, 102, 255, 1)'    
            ],
            borderWidth: 1
          }]
        },
        options: {
          scales: {
            y: {
              beginAtZero: true
            }
          }
        }
      });

 
    new Chart(pieCtx, {
      type: 'pie',
      data: {
        labels: platforms,
        datasets: [{
          label: 'Number of Users (millions)',
          data: usersData,
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',  
            'rgba(54, 162, 235, 0.2)',  
            'rgba(255, 206, 86, 0.2)',  
            'rgba(75, 192, 192, 0.2)',  
            'rgba(153, 102, 255, 0.2)', 
          ],
          borderColor: [
            'rgba(255, 99, 132, 1)',  
            'rgba(54, 162, 235, 1)',    
            'rgba(255, 206, 86, 1)',    
            'rgba(75, 192, 192, 1)',   
            'rgba(153, 102, 255, 1)',   
          ],
          borderWidth: 1
        }]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false, 
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
        
      
    });

    
    new Chart(lineCtx, {
      type: 'line',
      data: {
        labels: platforms,
        datasets: [{
          label: 'Number of Users (millions)',
          data: usersData,
          borderColor: 'rgba(75, 192, 192, 1)',
          backgroundColor: 'rgba(75, 192, 192, 0.2)',
          fill: false, 
          borderWidth: 2
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });

    new Chart(areaCtx, {
      type: 'line',
      data: {
        labels: platforms,
        datasets: [{
          label: 'Number of Users (millions)',
          data: usersData,
          borderColor: 'rgba(54, 162, 235, 1)',
          backgroundColor: 'rgba(54, 162, 235, 0.2)',
          fill: true,
          borderWidth: 2
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });
  })
  .catch(error => {
    console.error('There has been a problem with your fetch operation:', error);
  });
