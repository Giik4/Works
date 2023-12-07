using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class scriptNPC : MonoBehaviour
{
    private NavMeshAgent agente;
    public GameObject pc;
    private Animator anim;
    private AudioSource som;

    // Start is called before the first frame update
    void Start()
    {
        agente = GetComponent<NavMeshAgent>();
        anim = GetComponent<Animator>();
        som = GetComponent<AudioSource>();
        InvokeRepeating("grunhir",5,15);
    }

    // Update is called once per frame
    void Update()
    {
        mover();
    }

    void mover(){
        agente.SetDestination(pc.transform.position);
        anim.SetBool("andando",true);
    }

    void grunhir(){
        som.Play();
    }
}
