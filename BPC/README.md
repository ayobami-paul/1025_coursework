## BPC 
system design for a clinic with functions to 
- add/remove patients
- search up appointments by therapist name
- search up appointments by therapist expertise
- book, cancel, change appointments

---
# assumptions:
- all appointments run for a maximum of one hour
- there are a fixed number of treatments under each expertise i.e :
1. physiotherapy: mobilisation of the spine and joints, massage, exercise therapy, electrotherapy
2. osteopathy: spinal manipulation, soft tissue techniques, cranial osteopathy
3. rehabilitation: pool rehabilitation, gait training, functional training,
4. neurological physiotherapy: neural mobilisation, coordination exercises

- therefore, adding expertise to a therapist automatically adds their treatments
- is the timetable of the therapist based solely on their availability and not on treatments
- where each therapist handles their own calendar/ schedule
- or should the clinic handle the booking timeslots and assign an available therapist to each booking
- 