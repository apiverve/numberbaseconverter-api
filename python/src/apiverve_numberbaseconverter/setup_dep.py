from setuptools import setup, find_packages

setup(
    name='apiverve_numberbaseconverter',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Number Base Converter converts numbers between any base from 2 to 36, including binary, octal, decimal, and hexadecimal. Pass a value with optional source and target bases to receive the converted string, base names, and exact decimal values.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/numberbaseconverter?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
