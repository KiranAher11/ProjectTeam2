export const NAV_ITEMS_LIST = [
    {
        permitTo: ['nurse','physician'], icon: 'inbox', navItem: 'Inbox', route: 'inbox/sharedinbox'
    },
    {
        permitTo: ['physician'], icon: 'notes', navItem: 'Visit Form', route: 'visit/visit_form'
    },
    {
        permitTo: ['nurse'], icon: 'notes', navItem: 'Vital Signs', route: 'visit/vital_form'
    },
    
    // {
    //     permitTo: ['physician'], icon: 'calendar_today', navItem: 'Calendar', route: 'schedule/calendarapi'
    // },
    { permitTo: ['admin'], icon: 'how_to_reg', navItem: 'Register Employee', route: 'admin/userRegistration'},
    {
        permitTo: ['patient'], icon: 'details', navItem: 'Patient Details', route: 'usermanagement/patient_details'
    },
    {
        permitTo: ['admin'], icon: 'people', navItem: 'Patient users', route: 'admin/userList'
    },
    {
        permitTo: ['admin'], icon: 'supervised_user_circle', navItem: 'Hospital Users', route: 'admin/hospitalUserList'
    },
    {
        permitTo: ['patient'], icon: 'schedule', navItem: 'Book Appointment', route: 'visit/appointment_form'
    },
    
    {
        permitTo: ['physician'], icon: 'event_note', navItem: 'Appointment Details', route: 'schedule/appointmentDetails'
    },
    {
        permitTo: ['physician','patient','admin','nurse'], icon: 'info', navItem: 'About CT', route: 'admin/about'
    }

];
