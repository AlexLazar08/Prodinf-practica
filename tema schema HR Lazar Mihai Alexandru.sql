//Afisati numele si salariile angajatilor:
SELECT first_name, last_name, salary
FROM employees; 

//Afisati numele de familie si salariul angajatilor 
//care castiga mai mult de $12,000:
SELECT last_name, salary
FROM employees
WHERE salary > 12000;

//Afisati numele de familie si salariul pentru toti angajatii al caror 
//salariu nu se afla in intervalul $5,000 - $12,000:
SELECT last_name, salary
FROM employees
WHERE salary NOT BETWEEN 5000 AND 12000;

//Afisati numele de familie, loc de munca (job ID) si data de inceput 
//(data angajarii) pentru angajatii cu numele de familie Smith si Taylor. 
//Ordonați rezultatele în ordine crescatore dupa data angajarii:
SELECT last_name, job_id, hire_date
FROM employees
WHERE last_name IN ('Smith', 'Taylor')
ORDER BY hire_date ASC;

//Afisati numele de familie si numele departamentului pentru angajatii 
//din departamentele 20 sau 50 in ordine alfabetica crescatoare dupa nume:
SELECT e.last_name, d.department_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id
WHERE d.department_id IN (20, 50)
ORDER BY e.last_name ASC;

//Afisati numele de familie si denumirea functiei pentru toti angajatii 
//care nu au un manager:
SELECT e.last_name, j.job_title
FROM employees e
JOIN jobs j ON e.job_id = j.job_id
WHERE e.manager_id IS NULL;

//Afisati numele de familie, salariul si comisionul pentru toti angajatii 
//care castiga comisioane. Sortati datele in ordine descrescatoare
//a salariilor si comisioanelor:
SELECT last_name, salary, commission_pct
FROM employees
WHERE commission_pct IS NOT NULL
ORDER BY salary DESC, commission_pct DESC;

//Gasiti cel mai mare, cel mai mic salariu si salariul mediu al tuturor 
//angajatilor. Etichetati coloanele Maxim, Minim, Suma si respectiv, Medie:
SELECT MAX(salary) AS Maxim, MIN(salary) AS Minim, AVG(salary) AS Suma
FROM employees;

//Modificati interogarea anterioara pentru a afisa Minim, Maxim, Suma si 
//salariul mediu pentru fiecare loc de munca (job_ID):
SELECT job_id, MAX(salary) AS Maxim, MIN(salary) AS Minim, AVG(salary) AS Suma
FROM employees
GROUP BY job_id;

//Afisati numarul persoanelor cu acelasi loc de munca:
SELECT job_id, COUNT(*) AS Numar_Persoane
FROM employees
GROUP BY job_id;

//Determinati numarul managerilor fara a lista angajatii. Etichetati 
//coloana Numarul Managerilor. Sugestie: Folositi coloana Manager_ID 
//din tabela cu angajati pentru a determina numarul managerilor:
SELECT COUNT(DISTINCT manager_id) AS Numarul_Managerilor
FROM employees;

//Gasiti diferenta dintre cel mai mare și cel mai mic salariu. 
//Etichetati coloana Diferenta:
SELECT MAX(salary) - MIN(salary) AS Diferenta
FROM employees;

//Gasiti adresele tuturor departamentelor. Utilizati tabelele 
//LOCATIONS si COUNTRIES:
SELECT l.location_id, l.street_address, l.city, c.country_name
FROM locations l
JOIN countries c ON l.country_id = c.country_id;

//Afisati la iesire, ID_Locatie, adresa strazii, orasul, statul 
//sau provincia si tara:
SELECT l.location_id, l.street_address, l.city, l.state_province, c.country_name
FROM locations l
JOIN countries c ON l.country_id = c.country_id;

//Afisati numele de familie, locul de munca, numarul departamentului si numele 
//departamentului pentru toti angajatii care lucreaza in Toronto:
SELECT e.last_name, e.job_id, e.department_id, d.department_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id
JOIN locations l ON d.location_id = l.location_id
WHERE l.city = 'Toronto';

//Arătați numele și numerele tuturor managerilor împreună cu numărul de 
//angajați care sunt subordonații fiecăruia:
SELECT m.employee_id, m.last_name, COUNT(e.employee_id) AS Numar_Angajati
FROM employees m
JOIN employees e ON m.employee_id = e.manager_id
GROUP BY m.employee_id, m.last_name;

//Creați o interogare care să afișeze numele departamentului, numele locației,
//denumirea funcției și salariul pentru acei angajați care lucrează 
//într-o locație specifică (dată):
SELECT d.department_name, l.location_name, j.job_title, e.salary
FROM employees e
JOIN departments d ON e.department_id = d.department_id
JOIN locations l ON d.location_id = l.location_id
JOIN jobs j ON e.job_id = j.job_id
WHERE l.location_name = 'NumeLocatie';

//Găsiți numărul angajaților al căror nume de familie se termină în litera "n":
SELECT COUNT(*) AS Numar_Angajati
FROM employees
WHERE last_name LIKE '%n';

//Creați o interogare care afișează numele, locația și numărul de angajați 
//pentru fiecare departament. Asigurați-vă că rezultatul include, 
//de asemenea, și departamentele fără angajați:
SELECT d.department_name, l.location_name, COUNT(e.employee_id) AS Numar_Angajati
FROM departments d
LEFT JOIN employees e ON d.department_id = e.department_id
LEFT JOIN locations l ON d.location_id = l.location_id
GROUP BY d.department_name, l.location_name;

//Afișați toți angajații care au fost angajați în prima jumătate a lunii 
//(înainte de ziua de 16 a lunii):
SELECT *
FROM employees
WHERE hire_date < TO_DATE('16-MM-YYYY', 'DD-MM-YYYY');

//Creați o interogare pentru a afișa numărul departamentelor cu 
//salariul mediu cel mai mare:
SELECT COUNT(*) AS Numar_Departamente
FROM (
  SELECT department_id, AVG(salary) AS Salariu_Mediu
  FROM employees
  GROUP BY department_id
  HAVING AVG(salary) = (
    SELECT MAX(AVG(salary))
    FROM employees
    GROUP BY department_id
  )
);

//Creați o interogare care afișează un departament în care nu lucrează 
//reprezentanți de vânzări. Includeți la ieșire, numărul departamentului, 
//numele departamentului și locația:
SELECT d.department_id, d.department_name, l.location_name
FROM departments d
JOIN locations l ON d.location_id = l.location_id
WHERE d.department_id NOT IN (
  SELECT department_id
  FROM employees
  WHERE job_id = 'SA_REP'
);



