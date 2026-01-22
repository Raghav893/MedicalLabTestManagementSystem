-- =========================
-- LAB TESTS (Company Catalog)
-- =========================

INSERT INTO lab_test (lab_test_id, test_code, test_name, description, price, active)
VALUES
    (1, 'CBC', 'Complete Blood Count', 'Measures overall health and detects a wide range of disorders', 350, true),

    (2, 'LIPID', 'Lipid Profile', 'Measures cholesterol and triglyceride levels', 450, true),

    (3, 'TSH', 'Thyroid Stimulating Hormone', 'Measures thyroid gland function', 300, true);

-- =========================
-- TEST PARAMETERS
-- =========================

-- ===== CBC PARAMETERS =====
INSERT INTO test_parameter
(test_param_id, lab_test_id, parameter_name, unit, min_range, max_range)
VALUES
    (101, 1, 'Hemoglobin', 'g/dL', 13, 17),

    (102, 1, 'RBC Count', 'million/µL', 4, 6),

    (103, 1, 'WBC Count', 'cells/µL', 4000, 11000),

    (104, 1, 'Platelet Count', 'lakhs/µL', 1, 4);

-- ===== LIPID PROFILE PARAMETERS =====
INSERT INTO test_parameter
(test_param_id, lab_test_id, parameter_name, unit, min_range, max_range)
VALUES
    (201, 2, 'Total Cholesterol', 'mg/dL', 0, 200),

    (202, 2, 'LDL Cholesterol', 'mg/dL', 0, 100),

    (203, 2, 'HDL Cholesterol', 'mg/dL', 40, 60),

    (204, 2, 'Triglycerides', 'mg/dL', 0, 150);

-- ===== TSH PARAMETERS =====
INSERT INTO test_parameter
(test_param_id, lab_test_id, parameter_name, unit, min_range, max_range)
VALUES
    (301, 3, 'TSH', 'µIU/mL', 0, 4);
