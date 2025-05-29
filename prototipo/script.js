document.addEventListener('DOMContentLoaded', function() {
    initNavigation();
    
    initTabs();
    
    scrollToToday();
});

function initNavigation() {
    const navItems = document.querySelectorAll('.nav-item');
    
    navItems.forEach(item => {
        item.addEventListener('click', function() {
            navItems.forEach(i => i.classList.remove('active'));
            
            this.classList.add('active');
            
            document.querySelectorAll('.page').forEach(page => {
                page.classList.remove('active');
            });
            
            const pageId = this.getAttribute('data-page');
            if (pageId) {
                document.getElementById(pageId).classList.add('active');
            }
        });
    });
}

function initTabs() {
    const tabs = document.querySelectorAll('.tab');
    
    tabs.forEach(tab => {
        tab.addEventListener('click', function() {
            tabs.forEach(t => t.classList.remove('active'));
            
            this.classList.add('active');
            
            const tabContainer = this.closest('.tabs').nextElementSibling;
            if (tabContainer) {
                tabContainer.querySelectorAll('.tab-content').forEach(content => {
                    content.classList.remove('active');
                });
                
                const tabId = this.getAttribute('data-tab');
                if (tabId) {
                    tabContainer.querySelector(`#${tabId}`).classList.add('active');
                }
            }
        });
    });
}

function showForm(formId) {
    document.getElementById(formId).classList.remove('hidden');
}

function hideForm(formId) {
    document.getElementById(formId).classList.add('hidden');
}

function scrollToToday() {
    const todayElement = document.querySelector('.today');
    if (todayElement) {
        todayElement.scrollIntoView({
            behavior: 'auto',
            block: 'center',
            inline: 'center'
        });
    }
}

document.addEventListener('click', function(e) {
    if (e.target.closest('[data-show-form]')) {
        const formId = e.target.closest('[data-show-form]').getAttribute('data-show-form');
        showForm(formId);
    }
    
    if (e.target.closest('[data-hide-form]')) {
        const formId = e.target.closest('[data-hide-form]').getAttribute('data-hide-form');
        hideForm(formId);
    }
});

function validatePatientForm() {
    const dni = document.getElementById('dni').value;
    const firstName = document.getElementById('firstname').value;
    const lastName = document.getElementById('lastname').value;
    
    if (!dni || !firstName || !lastName) {
        alert('Por favor, complete los campos obligatorios');
        return false;
    }
    
    return true;
}